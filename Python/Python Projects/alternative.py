text = str(raw_input("Please enter any text: "))
temp = ""
ls = list(text)

for i in range (len(ls)):
    if i%2 ==0:
        temp += ls[i].lower()
    else:
        temp += ls[i].upper()

print "\n",temp