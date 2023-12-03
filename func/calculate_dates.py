from datetime import datetime
from datetime import timedelta

def calculateDates() -> str:  
    formatedToday = datetime.today().date()

    return f"Amanhã ({formatedToday + timedelta(days=1)}) | em 7 days: {formatedToday + timedelta(days=7)} | em 30 days: {formatedToday + timedelta(days=30)}" 
