week = {
	"mon":[],
	"tue":[],
	"wed":[],
	"thu":[],
	"fri":[],
	"sat":[],
	"sun":[]
}

def hour2min(time):
	t = time.split(":")
	if t[0] == "00":
		return int(t[1])
	else:
		return (int(t[0])*60) + int(t[1]) 	

def overlap(day, newStart, newEnd):
	for i in week[day]:
		if hour2min(i.split("-")[0]) < hour2min(newStart) < hour2min(i.split("-")[1]):
			return True 
		elif hour2min(i.split("-")[0]) <= hour2min(newEnd) <= hour2min(i.split("-")[1]):
			return True
	return False

def add_appointment(day_name_start_finish):
	day,name,start,finish = day_name_start_finish.split(' ')
	if int(start.split(':')[1]) >= 60 or int(finish.split(':')[1]) >= 60:
		return "Invalid minutes"
	if  1440 < hour2min(start) or 1440 < hour2min(finish):
		return "Invalid time"
	if overlap(day, start, finish):
		return "Appointement overlap"
	else:
		week[day].append(name+" "+start + "-" + finish)
		return "Appointement added"

def rem_appointment(day_start):
	day,start = day_start.split(' ')
	if int(start.split(':')[1]) >= 60:
		return "Invalid minutes"
	if  1440 < hour2min(start):
		return "Invalid time"
	for i,val in enumerate(week[day]):
		if start in week[day][i]:
			week[day].remove(val)
			print("Appointement Removed")

print("Functions:\nadd\nrem\nshow\nshowDay\n---")
s = input()
while s != 'quit':
	if s == 'add':
		print("Enter: day name start finish ex. mon dentist 12:43 16:40")
		print(add_appointment(input()))
	elif s == 'rem':
		print("Enter: day start ex. sun 00:12")
		print(rem_appointment(input()))
	elif s == 'show':
		print(week)
	elif s == 'showDay':
		print("Enter: day ex. fri")
		print(week[input()])
	elif s == 'help':
		print("---\nFunctions:\nadd\nrem\nshow\nshowDay\n---")
	else:
		print("Enter 'help' to see functions")
	s = input()