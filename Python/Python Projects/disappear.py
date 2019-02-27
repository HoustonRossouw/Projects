text = str(raw_input("Please write any sentence\n"))
text_split = str(raw_input("Please enter the letter you would like to take out:"))

split_text = text.split(text_split)

split_text = "".join(split_text)

print split_text


