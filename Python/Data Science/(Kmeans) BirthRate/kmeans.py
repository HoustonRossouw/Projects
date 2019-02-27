#K-Means clustering implementation

#Some hints on how to start have been added to this file.
#You will have to add more code that just the hints provided here for the full implementation.

from copy import deepcopy #read about it
import numpy as np
import pandas as pd
from matplotlib import pyplot as plt
# ====
# Define a function that computes the distance between two data points
def dist(a,b, ax=1):
    return np.linalg.norm(a-b, axis=ax)

# ====
# Define a function that reads data in from the csv files  HINT: http://docs.python.org/2/library/csv.html
def GetData(fileName):
    data = pd.read_csv(fileName)
    return data

# ====
# Write the initialisation procedure
clusterCount = int(raw_input("Please enter the Cluster count (K-mean):"))
iterationCount = int(raw_input("Please enter the Iteration count "))

data = GetData("dataBoth.csv")
countries = data['Countries']
f1 = data['BirthRate(Per1000)']
f2 = data['LifeExpectancy']

X=np.array(list(zip(f1,f2)))
cDict = {}

for i in range(countries.size):
    cDict[str (X[i])] = countries[i]


# ====
# Implement the k-means algorithm, using appropriate looping
C_x = np.random.randint(0,np.max(X), size = clusterCount)
C_y = np.random.randint(0,np.max(X), size = clusterCount)
C = np.array(list(zip(C_x, C_y)), dtype=np.float32)

C_old = np.zeros(C.shape)
clusters = np.zeros(len(X))

iteration = 0
colors = ['r', 'g', 'b', 'y', 'c', 'm']
fig, ax = plt.subplots()

plt.scatter(f1,f2, c='#050505',s=20)
plt.scatter(C_x,C_y, marker='*', s=200, c='g')

lables = clusters

for i in range(clusterCount):
    points = np.array([X[j]for j in range(len(clusters)) if lables[j] ==i])
ax.scatter(C[:,0],C[:,1], marker = '*',s=200, c='r')
#print(C)

def writetotxt():
    f = open("interpretation.txt","w+")
    convert = np.array2string(C, formatter={'int':lambda C: hex(C)})
    f.write(convert)
    f.close()

writetotxt()

plt.show()

