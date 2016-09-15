# WynnWikiCodeUpdater
For manipulating wiki code to fit current need

The goal:
  User feed in template such as"{{Outdated|update=}}"
  User feed in data that isn't formated such as"update GameplayUpdate ioih 30hjko"
  This program should extract all the words and assign correct value to its variable in template.
  Such as"{{Outdated|update=GameplayUpdate}}"
  
  In the futurem, this program should be able to handle all kind of template. And it can regonize different
  words that mean the same thing, such as walking_speed = walk speed = WALK_SPEED. 
