enum class Alignment {
    LEFT,
    RIGHT,
    CENTER,
}

fun alignText(
    text: String,
    lineWidth: Int = 120,
    alignment: Alignment = Alignment.LEFT
    ): String {
    if (lineWidth <= 0)
        throw IllegalArgumentException("Invalid line width value!")
    return when (alignment) {
        Alignment.LEFT -> toText(alignmentLeft(text, lineWidth))
        Alignment.RIGHT -> toText(alignmentRight(text, lineWidth))
        Alignment.CENTER -> toText(alignmentCenter(text, lineWidth))
    }
}

fun toText(listOfText: ArrayList<String>): String{
    var text = ""
    for (string in listOfText) {
        text += "$string\n"
    }
    return text
}

fun alignmentLeft(text: String, lineWidth: Int): ArrayList<String> {
    val words = text.split(" ").toMutableList()
    val newText: ArrayList<String> = arrayListOf()
    var currentString = ""
    var i = 0
    while (i <= words.lastIndex) {
        if ((currentString.length + words[i].length + 1) <= lineWidth) {
            currentString += words[i++] + ' '
        }
        else if ((currentString.length + words[i].length) == lineWidth) {
            currentString += words[i++]
            newText.add(currentString)
            currentString =""
        }
        else if (currentString.isEmpty() and (words[i].length >= lineWidth)) {
            //splitting a long word into small pieces
            var longWord = words[i]
            while (longWord.isNotBlank() and (longWord.length >=lineWidth)) {
                    newText.add(longWord.substring(0, lineWidth))
                    longWord = longWord.substring(lineWidth)
            }
            if (longWord.length < lineWidth) {
                words[i] = longWord
            }
        } else
            if ((currentString.length + words[i].length + 1) > lineWidth)  {
                newText.add(currentString)
                currentString = ""
            }
    }
    if (currentString.isNotEmpty()) newText.add(currentString)
    //deleting extra spaces at the end of the string
    for (j in 0 until newText.size) {
        if (newText[j].last() == ' ')
            newText[j] = newText[j].substring(0, newText[j].length-1)
    }
    return newText
}

fun alignmentRight(text: String, lineWidth: Int): ArrayList<String> {
    val alignedLeftText = alignmentLeft(text, lineWidth)
    val newText: ArrayList<String> = arrayListOf()
    //putting extra spaces into beginning of string to make it aligned at right
    for (string in alignedLeftText) {
        newText.add("".padStart((lineWidth - string.length), ' ') + string)
    }
    return newText
}

fun alignmentCenter(text: String, lineWidth: Int): ArrayList<String> {
    val alignedLeftText = alignmentLeft(text, lineWidth)
    val newText: ArrayList<String> = arrayListOf()
    //putting extra spaces into beginning and ending of string to make it aligned at center
    for (string in alignedLeftText) {
        newText.add("".padStart((lineWidth - string.length)/2, ' ') + string + "".padStart((lineWidth - string.length)/2, ' '))
    }
    return newText
}