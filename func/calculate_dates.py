from datetime import datetime
from datetime import timedelta

def calculateDates() -> str:  
    formatedToday = datetime.today().date()

    return f"Amanhã ({formatedToday + timedelta(days=1)}) | em 7 dias: {formatedToday + timedelta(days=7)} | em 15 dias: {formatedToday + timedelta(days=30)} | em 30 dias: {formatedToday + timedelta(days=30)}" 
