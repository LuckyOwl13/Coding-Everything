import numpy as np
from sklearn import tree
from sklearn import svm
from sklearn.naive_bayes import GaussianNB
from operator import itemgetter

#Learning inputs for the algorithm
#[height, weight, shoe size]
X = [[181,80,44], [177,70,43], [160,60,38], [154,54,37],
	 [166,65,40], [190,90,47], [175,64,39], [177,70,40],
	 [159,55,37], [171,75,42], [181,85,43]]
#Correct answers for each input item
Y = ['male', 'female', 'female', 'female', 'male', 
	 'male', 'male', 'female', 'male', 'female', 'male']

#Set counters
DTcounter100 = 0
DTcounter50 = 0
DTcounter0 = 0
#Evaluate DecisionTreeClassifier
for x in range (0,100):
	correct = 0
	#Create and train the classifier
	clf = tree.DecisionTreeClassifier()
	clf = clf.fit(X,Y)
	#Test the classifier using new items a bunch of times
	prediction = clf.predict([[190,70,43],[160,52,37]])
	
	if prediction[0] == 'male':
		correct += 50
	if prediction[1] == 'female':
		correct += 50
	
	if correct == 0:
		DTcounter0 += 1
	elif correct == 50:
		DTcounter50 += 1
	else:
		DTcounter100 += 1
#end for
print("Using DecisionTreeClassifier-")
print("# 100%: " + str(DTcounter100))
print("# 50%: " + str(DTcounter50))
print("# 0%: " + str(DTcounter0))

#Set counters
SVCcounter100 = 0
SVCcounter50 = 0
SVCcounter0 = 0
#Evaluate Support Vector Classifier (SVC)
for x in range (0,100):
	correct = 0
	#Create and train the classifier
	clf = svm.SVC()
	clf = clf.fit(X,Y)
	#Test the classifier using new items a bunch of times
	prediction = clf.predict([[190,70,43],[160,52,37]])

	if prediction[0] == 'male':
		correct += 50
	if prediction[1] == 'female':
		correct += 50
	
	if correct == 0:
		SVCcounter0 += 1
	elif correct == 50:
		SVCcounter50 += 1
	else:
		SVCcounter100 += 1
#end for
print("\nUsing SVC-")
print("# 100%: " + str(SVCcounter100))
print("# 50%: " + str(SVCcounter50))
print("# 0%: " + str(SVCcounter0))

#Set counters
GNBcounter100 = 0
GNBcounter50 = 0
GNBcounter0 = 0
#Evaluate Naive Bayes Classifier
for x in range (0,100):
	correct = 0
	#Create and train the classifier
	clf = GaussianNB()
	clf = clf.fit(X,Y)
	#Test the classifier using new items a bunch of times
	prediction = clf.predict([[190,70,43],[160,52,37]])

	if prediction[0] == 'male':
		correct += 50
	if prediction[1] == 'female':
		correct += 50
	
	if correct == 0:
		GNBcounter0 += 1
	elif correct == 50:
		GNBcounter50 += 1
	else:
		GNBcounter100 += 1
#end for
print("\nUsing GNB-")
print("# 100%: " + str(GNBcounter100))
print("# 50%: " + str(GNBcounter50))
print("# 0%: " + str(GNBcounter0))

#Put each classifier and its counters into a list
dtc = ["DTC", DTcounter100, DTcounter50, DTcounter0]
svc = ["SVC", SVCcounter100, SVCcounter50, SVCcounter0]
gnb = ["GNB", GNBcounter100, GNBcounter50, GNBcounter0]
#Sort the lists
fullCorr = sorted([dtc,svc,gnb],key=itemgetter(1),reverse=True)
halfCorr = sorted([dtc,svc,gnb],key=itemgetter(2),reverse=True)
noneCorr = sorted([dtc,svc,gnb],key=itemgetter(3),reverse=True)

#State which classifier is best; if tied, share the best.
print()
if fullCorr[0][0] > fullCorr[1][0]:
	print(fullCorr[0][0] + " is the best classifier")
elif fullCorr[0][0] == fullCorr[1][0] > fullCorr[2][0]:
	print(fullCorr[0][0] + " and " + fullCorr[1][0] + " are the best classifiers")
else:
	print("No classifier is better than the others")