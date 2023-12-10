def checkDuplicates(subject: str) -> bool: 
    with open("reviews.txt", "r", encoding="utf-8") as f: 
        Lines = f.readlines()

        for line in Lines: 
            if subject in line.upper(): 
                return True 
    return False 