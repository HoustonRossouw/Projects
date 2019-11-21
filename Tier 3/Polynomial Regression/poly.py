import numpy as np
import matplotlib.pyplot as plt

from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

# Training set
x_train = [[2009], [2010], [2011], [2012], [2013], [2014], [2015], [2016], [2017], [2018], [2019]] #Years
y_train = [[1.36], [2.40], [2.26], [1.43], [1.10], [1.67], [1.27], [1.37], [1.26], [1.01], [1.06]] #prices of coffee over the years

# Testing set
x_test = [[2009], [2010], [2011], [2012], [2013], [2014], [2015], [2016], [2017], [2018], [2019]] #Years
y_test = [[1.10], [1.41], [2.34], [2.27], [1.49], [1.11], [1.61], [1.23], [1.37], [1.30], [0.99]] ##prices of coffee over the years

# Train the Linear Regression model and plot a prediction
regressor = LinearRegression()
regressor.fit(x_train, y_train)
xx = np.linspace(0, 8000, 2020)
yy = regressor.predict(xx.reshape(xx.shape[0], 1))
plt.plot(xx, yy)

# Set the degree of the Polynomial Regression model
quadratic_featurizer = PolynomialFeatures(degree=10)

# This preprocessor transforms an input data matrix into a new data matrix of a given degree
X_train_quadratic = quadratic_featurizer.fit_transform(x_train)
X_test_quadratic = quadratic_featurizer.transform(x_test)

# Train and test the regressor_quadratic model
regressor_quadratic = LinearRegression()
regressor_quadratic.fit(X_train_quadratic, y_train)
xx_quadratic = quadratic_featurizer.transform(xx.reshape(xx.shape[0], 1))

# Plot the graph
plt.plot(xx, regressor_quadratic.predict(xx_quadratic), c='r', linestyle='--')
plt.title('Coffee Prices - 10 Year')
plt.xlabel('Coffee prices past 10 year ')
plt.ylabel('Price in dollars')
plt.axis([2009, 2019, 1, 3])
plt.grid(True)
plt.scatter(x_train, y_train)
plt.show()
