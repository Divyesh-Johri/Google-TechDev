"""
Began 11/3/19
Divyesh Johri

Given a string S and a set of words D, find the longest word in D that is a subsequence of S.

Word W is a subsequence of S if some number of characters, possibly zero, can be
deleted from S to form W, without reordering the remaining characters.

Note: D can appear in any format (list, hash table, prefix tree, etc.

For example, given the input of S = "abppplee" and
D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"

The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".

The word "bale" is not a subsequence of S because even though S has all the right letters,
they are not in the right order.

The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.
"""

string = "abppplee"
wordList = ["able", "ale", "apple", "bale", "kangaroo"]
#print(subsequence(string, wordList))

def subsequence(self, string, wordList):
    #goodWords will contain words that are subsequent of the string
    goodWords = []

    for i in wordList:
        if self.evaluate(string, i):
            goodWords.append((i, len(i))

    #Sort goodWords by their length using a lambda function
    goodWords.sort(key= lambda t: t[1])

    return goodWords[0]

"""
Helper method for subsequence(), will determine if word given is subsequent to
given string through boolean
"""
def evaluate(self, string, word):
    n = 0
    for i in string:
        if i == word[n]:
            n += 1
    return n == len(word)
