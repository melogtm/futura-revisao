from func.calculate_dates import calculateDates


def subjectToFile(subject_name: str) -> None:

    stringReview = calculateDates() 

    with open("reviews.txt", 'a', encoding='utf-8') as f: 
        reviewFormat = f"Vamos rever {subject_name} {stringReview}"
        
        print(reviewFormat)
        
        f.write(reviewFormat + '\n')
