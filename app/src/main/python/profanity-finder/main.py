from profanation import profanity
from textblob import TextBlob

def main(text):
    text_input = text
    score = TextBlob(text_input).sentiment.polarity

    if profanity.contains_profanity(text_input):
        value = "Profanity"
    else:
        if score < 0:
            value = "Negative"
        elif score > 0:
            value = "positive"
        else:
            value = "Neutral"

    
    return value



