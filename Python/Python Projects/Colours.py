name = raw_input ("Please enter your name:")
surename = raw_input ("Please enter your surename:")
finish_swimtime = int(raw_input("Please enter your finish time for swimming(To the nearest minute):"))
finish_biketime = int(raw_input("Please enter your finish time for cycling(To the nearest minute):"))
finish_runtime  = int(raw_input("Please enter your finish time for running(To the nearest minute):"))
position = int(raw_input("Please enter your position you came in the race:"))

finish_total = finish_swimtime + finish_biketime + finish_runtime

award = "Provincial Colours"
award1 = "Provincial Half Colours"
award2 = "Provincial Scroll"
award3 = "Provincial Certificate"

if finish_total <= 100 and position == 1:
	print "Congratulations", name,surename ,"you finished:",position
	print "your Award is:", award
elif finish_total <= 110 and position <=2:
	print "Congratulations", name,surename ,"you finished:",position
	print "your Award is:", award1
elif finish_total <= 115:
	print "Congratulations", name,surename ,"you finished:",position
	print "your Award is:", award2
elif finish_total <=120:
	print "Congratulations", name,surename ,"you finished:",position
	print "your Award is:", award3
elif finish_total > 120:
	print "Congratulations", name,surename ,"you finished:",position





