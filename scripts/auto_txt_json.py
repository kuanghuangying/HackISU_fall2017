import os

#get all txt files
all_txts = [t for t in os.listdir("YOUR PATH HERE")]

for x in all_txts:
	json_file = x.replace(".txt", ".json")
	os.system("java -cp 'bin/*:../GATEFiles/lib/*:../GATEFiles/bin/gate.jar:lib/*' code4goal.antony.resumeparser.ResumeParserProgram " + x + " " + json_file)
