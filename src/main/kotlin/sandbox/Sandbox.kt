package sandbox

class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val closeToOpenMap = HashMap<Char, Char>()
        closeToOpenMap[')'] = '('
        closeToOpenMap['}'] = '{'
        closeToOpenMap[']'] = '['

        for (c in s) {
            if (c in closeToOpenMap) {
                if (stack.lastOrNull() == closeToOpenMap[c]) {
                    stack.removeLast()
                } else {
                    return false
                }
            } else {
                stack.add(c)
            }
        }

        return stack.isEmpty()
    }
}
