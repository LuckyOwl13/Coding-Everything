
# This class is to define what a spell is, which is to say, an object consisting of 
# the spell's name, its level, and its school

class Spell(object):
	name = "default"
	level = -1
	school = "default"
	
	def __init__(self,name,level,school):
        self.name = name
		self.level = level
		self.school = school
		