'''
Created on Nov 4, 2018

@author: Caitlin
'''
# "RandomEffectsV2_text.txt"

effects = []

with open("RandomEffectsV2_text.txt", 'r') as file: 
    for line in file:
        effects += [line.strip()]
    
    print("done !")
    
print(effects)

input()