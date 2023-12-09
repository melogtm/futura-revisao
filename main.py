from func.write_to_file import subjectToFile 
import sys 

helper_message = """
Para usar esse script, utilize a seguinte formatação: 

python(3) main.py "Assunto que eu quero revisar"

As aspas são recomendadas para englobar todo o assunto, cajo haja espaços. 
"""

if (len(sys.argv) <= 1):
    print(helper_message)
    exit(-1)

if (len(sys.argv) > 2):
    print(f"Somente {sys.argv[1]} irá ser alocado no ficheiro de revisões. É isso que deseja? (digite n/N para negar) ")
    uConfirmation = input("")
    
    if (uConfirmation.upper() == "N"): 
        print(helper_message)
        exit(-1)

subjectToFile(sys.argv[1])