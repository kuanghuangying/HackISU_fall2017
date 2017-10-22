import os

#get all files in a directory
all_pdfs = [p for p in os.listdir("ENTER PATH HERE")]

#for each pdf, make text_file string with .txt extention
#convert to pdf
for x in all_pdfs:
	text_file = x.replace(".pdf", ".txt")
	# pdf2txt.py -o OUTPUTFOLDER/output.txt pdf_folder/pdf_name.pdf
	os.system("pdf2txt.py -o " + text_file + " samps/" + x)
