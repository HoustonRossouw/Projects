import matplotlib.pyplot as plt
#loading Iris data into the file
from sklearn.datasets import load_iris
import numpy as np

fig = plt.figure()
ax1 = plt.subplot(2,1,1)
ax2 = plt.subplot(2,1,2)
#using the data that was imported 
iris = load_iris()
data = np.array(iris['data'])
targets = np.array(iris['target'])
#adding colors
cd = {0:'r',1:'b',2:'g'}
cols = np.array([cd[target] for target in targets])
#printing the scatter plots.
ax1.scatter(data[:,0], data[:,1],c=cols)
ax2.scatter(data[:,1], data[:,2], c=cols)

plt.show()
#Blow are the different scatter plots
"""
Figure 0
ax1.scatter(data[:,0], data[:,1],c=cols)
ax2.scatter(data[:,1], data[:,2], c=cols)
Figure 1
ax1.scatter(data[:,2], data[:,0],c=cols)
ax2.scatter(data[:,0], data[:,2], c=cols)
Figure 2
ax1.scatter(data[:,2], data[:,1],c=cols)
ax2.scatter(data[:,1], data[:,0], c=cols)
"""