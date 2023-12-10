from func.calculate_dates import calculateDates
from func.searchDuplicates import checkDuplicates


def subjectToFile(subject_name: str) -> None:

    stringReview = calculateDates() 

    with open("reviews.txt", 'a+', encoding='utf-8') as f: 
        reviewFormat = f"Vamos rever {subject_name} {stringReview}"

        if checkDuplicates(subject_name.upper()): 
            print("Matéria já registrada.")
            exit(-1)

        print(reviewFormat)
        
        f.write(reviewFormat + '\n')
