package utils;


public class JavaCodeFormatter {

    public String formatCode(String code) {
        StringBuilder formattedCode = new StringBuilder();
        String[] lines = code.split("\n");
        int indentLevel = 0;
        String indent = "    "; // 4 spaces for indentation
        boolean inMultilineBlock = false;

        for (String line : lines) {
            line = line.trim();

            if (line.endsWith("}")) {
                indentLevel--;
            }

            if (!inMultilineBlock) {
                for (int i = 0; i < indentLevel; i++) {
                    formattedCode.append(indent);
                }
            } else {
                formattedCode.append(" ");
            }

            formattedCode.append(line).append("\n");

            if (line.endsWith("{")) {
                indentLevel++;
            }

            if (line.endsWith("{") || line.endsWith("}")) {
                inMultilineBlock = false;
            } else if (line.contains("{")) {
                inMultilineBlock = true;
            }
        }

        return formattedCode.toString();
    }

}
