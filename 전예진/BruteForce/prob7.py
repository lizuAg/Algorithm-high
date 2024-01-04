answer = [0]
word_dict = {}
    
def generate_words(current_word, depth, vowels):
    if depth > 5:
        return

    word_dict[current_word] = answer[0]
    answer[0] += 1

    for vowel in vowels:
        generate_words(current_word + vowel, depth + 1, vowels)

def solution(word):
    vowels = 'AEIOU'
    generate_words('', 0, vowels)

    return word_dict[word]
