import matplotlib.pyplot as plt
import numpy as np
from sklearn.datasets import load_diabetes
from sklearn import linear_model
from statistics import mean
import math

d = load_diabetes()
d_X = d.data[:, np.newaxis, 2]
dx_train = d_X[:-20]
dy_train = d.target[:-20]
dx_test = d_X[-20 :]
dy_test = d.target[-20 :]

dx_train_array = dx_train.flatten()

def bestFitSlopeAndIntercept(xs,ys):
    m = (((mean(xs)*mean(ys)) - mean(xs*ys)) / ((mean(xs)* mean(xs)) - mean(xs*xs))) 
    b = mean(ys) - m*mean(xs)
    return m,b

m,b = bestFitSlopeAndIntercept(dx_train_array,dy_train)

Regression_Line = [(m*x) + b for x in dx_test]

plt.scatter(dx_train,dy_train, c ='r')
plt.scatter(dx_test,dy_test, c ='g')
plt.plot(dx_test,Regression_Line, c ='b')
plt.show()