/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikiupdater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JFrame;

/**
 * For updating template on Wynncraft wiki
 * @author Tong Shen
 */
public class WikiUpdater {
    static ArrayList Memory = new ArrayList();
    static Graphics gui = new Graphics();
    static HashMap TemplateMap = new HashMap();
    static int MemorySlot = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        JFrame frame = new JFrame("WynnCraft Wiki Updater");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(250, 250);
//        frame.setVisible(true);
        //String s = gui.GetInput();
        //Reading("dss oiu   |@# oolp");
        Run();
        
    }
    
    //This run method currently serving as a test subject
    static void Run(){
        int one = Reading("update GamePlay ewotwu we21");
        Template Outdated = new Template("{{Outdated|update=}}");
        Comparing(Sorting(one), Outdated);
        gui.ConsoleOutput(Outdated.GetResult());
    }
    /**
     * This method separate a sentence into a list of words. Give default value 
     * false to isTemplate
     * @param s A long String segment that need to be separated
     * @return Index of the result word ArrayList in the Memory
     */
    static int Reading(String s){
        return Reading(s, false);
    }
    /**
     * This method separate a sentence into a list of words.
     * @param s A long String segment that need to be separated
     * @param isTemplate If yes, the word will put into a map for future insertion
     * @return Index of the result word ArrayList in the Memory
     */
    static int Reading(String s, boolean isTemplate){
        ArrayList WordList = new ArrayList();
        char[] c = s.toCharArray();
        ArrayList word = new ArrayList();
        for (int i = 0; i < c.length; i++) {
            gui.ConsoleOutput(word.toString());
            if (Character.isAlphabetic(c[i])) {
                word.add(c[i]);
                if (i == c.length-1) {
                    String result_word = "";
                    for (int j = 0; j < word.size(); j++) {
                        result_word += word.get(j).toString();
                    }
                    gui.ConsoleOutput(result_word);
                    WordList.add(result_word);
                    word.clear();
                }
            }else{
                if (word.isEmpty()) {
                    continue;
                }
                gui.ConsoleOutput("One word ends.");
                String result_word ="";
                for (int j = 0; j < word.size(); j++) {
                    result_word += word.get(j).toString();
                }
                gui.ConsoleOutput(result_word);
                if (isTemplate) {
                    TemplateMap.put(result_word, i);
                }
                WordList.add(result_word);
                word.clear();
            }
        }
        Memory.add(MemorySlot, WordList);
        MemorySlot++;
        gui.ConsoleOutput(WordList.toString());
        return Memory.indexOf(WordList);
    }
    
    /**
     * Required for non-template string
     * @param index Which string string in Memory need to be sorted
     * @return The map of key and value
     */
    static HashMap Sorting(int index){
        HashMap WordPair = new HashMap();
        ArrayList target = (ArrayList)Memory.get(index);
        boolean spacer = true;
        for (int i = 0; i < target.size(); i++) {
            if (spacer) {
                WordPair.put(target.get(i), target.get(i+1));
                spacer = false;
            }else{
                spacer = true;
            }
        }
        return WordPair;
    }
    
    
    /**
     * Compare the original and the template. Then call the Inserting method
     * @param map The map come out from Sorting, of the word of value
     * @param t The template that intend to be followed
     */
    static void Comparing(HashMap map, Template t){
        Set r = map.keySet();
        Object[] target = r.toArray();
        ArrayList template;
        for (int i = 0; i < target.length; i++) {
            template = t.GetClosest((String) target[i]);
            if (template.size() == 1) {
                t.Inserting((String) template.get(0), (String) map.get(target[i]));
            }else{
                //TODO: Do some advance comparesion
            }
        }
    }
    
    static class Template{
        ArrayList template;
        int index;
        /**
         * Constructor for Template class.
         * @param string The template
         */
        private Template(String string){
            template = new ArrayList();
            index = Reading(string,true);
            char[] c = string.toCharArray();
            for (int i = 0; i < c.length; i++) {
                template.add(c[i]);
            }
        }
        /**
         * Get the closest template variable to this string
         * @param s The word that is being looked for in the template
         * @return An list of words that considered closest, if it not sure, 
         * return all the variable in the template
         */
        ArrayList GetClosest(String s){
            ArrayList z = (ArrayList) Memory.get(index);
            for (int i = 0; i < z.size(); i++) {
                if (s.equals(z.get(i))) {
                    ArrayList a = new ArrayList();
                    a.add(z.get(i));
                    gui.ConsoleOutput("Template/GetClosest-Y "+s+"="+a.toString());
                    return a;
                }
            }
            gui.ConsoleOutput("Template/GetClosest-N "+s+"="+z.toString());
            return z;
        }
        
        /**
         * Give the final String representation of the sentence in the template 
         * format.
         * @return Final result of the processed sentence
         */
        String GetResult(){
            String result = "";
            for (int i = 0; i < template.size(); i++) {
                result += template.get(i);
            }
            return result;
        }
        
        /**
         * This method insert the value after the keyword in the template
         * @param keyword Which variable in the template 
         * @param value What value should it be assigned
         */
        void Inserting(String keyword, String value){
            int[] VariablePos = new int[2];
            int key = (int) TemplateMap.get(keyword);
            for (int i = key; i < template.size(); i++) {
                if (template.get(i).equals('=')) {
                    VariablePos[0] = i+1;
                }
                if (template.get(i).equals('|') || template.get(i).equals('}')) {
                    VariablePos[1] = i;
                    break;
                }
            }
            int del = VariablePos[1]-VariablePos[0];
            if (del>=1) {
                for (int i = 0; i < del; i++) {
                    template.remove(VariablePos[0]+i);
                }
            }
            String V = value;
            char[] c = V.toCharArray();
            char[] r = new char[c.length];
            for (int i = 0; i < c.length; i++) {
                r[r.length-1-i] = c[i];
            }
            for (int i = 0; i < r.length; i++) {
                template.add(VariablePos[0], r[i]);
            }
        }
        
    }
}
