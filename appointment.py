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
			print("Hit1")
			return True 
		elif hour2min(i.split("-")[0]) <= hour2min(newEnd) <= hour2min(i.split("-")[1]):
			print("Hit2")
			return True
	return False

def add_appointment(day_name_start_finish):
	day,name,start,finish = day_name_start_finish.split(' ')
	if  1440 < hour2min(start) or 1440 < hour2min(finish):
		return "Invalid time"
	if overlap(day, start, finish):
		return "Appointement overlap"
	else:
		week[day].append(name+" "+start + "-" + finish)
		return "Appointement added"

def rem_appointment(day_start_finish):
	day,start = day_start_finish.split(' ')
	if  1440 < hour2min(start):
		return "Invalid time"
	for i,val in enumerate(week[day]):
		if start in week[day][i]:
			week[day].remove(val)
			print("Appointement Removed")

print("Functions:\nadd\nrem\nshow")
s = input()
while s != 'quit':
	if s == 'add':
		print("Enter: day name start finish ex. mon dentist 12:43 16:40")
		print(add_appointment(input()))
	if s == 'rem':
		print("Enter: day start ex. sun 00:12")
		print(rem_appointment(input()))
	if s == 'show':
		print(week)
	s = input()