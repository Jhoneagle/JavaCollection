package io.github.jhoneagle.math.calculator;

public class BooleanExec {
    private String param;

    public BooleanExec() {
    }

    public BooleanExec(String param) {
        this.param = replace(param, " ", "");
    }

    public Boolean eval(String param) {
        this.param = replace(param, " ", "");
        return eval();
    }

    public Boolean eval() {
        String clean = replace(param, " ", "");

        if (param.contains("1") || param.contains("0")) {
            return evalNumbers(clean);
        } else if (param.contains("true") || param.contains("false")) {
            return evalConditions(clean);
        } else {
            return false;
        }
    }

    private String replace(String old, String which, String toWhat) {
        return old.replace(which, toWhat);
    }

    private boolean evalNumbers(String numberLogic) {
        String simplified = newCondition(numberLogic);

        while (simplified.length() > 1) {
            simplified = replace(simplified, "(1)", "1");
            simplified = replace(simplified, "(0)", "0");

            simplified = newCondition(simplified);
        }

        if (Integer.parseInt(simplified) == 1) {
            return true;
        } else {
            return false;
        }
    }

    private String newCondition(String numberLogic) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                String what = i + "v" + j;
                String with = i + j > 0 ? "1" : "0";
                numberLogic = replace(numberLogic, what, with);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                String what = i + "^" + j;
                String with = i + j > 1 ? "1" : "0";
                numberLogic = replace(numberLogic, what, with);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                String what = i + ">" + j;
                String with = (i == 1 && j == 0) ? "0" : "1";
                numberLogic = replace(numberLogic, what, with);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                String what = i + "=" + j;
                String with = i == j ? "1" : "0";
                numberLogic = replace(numberLogic, what, with);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                String what = i + "o" + j;
                String with = i != j ? "1" : "0";
                numberLogic = replace(numberLogic, what, with);
            }
        }

        for (int i = 0; i < 2; i++) {
            String what = "!(" + i + ")";
            String with = i == 0 ? "1" : "0";
            numberLogic = replace(numberLogic, what, with);
        }

        return numberLogic;
    }

    private boolean evalConditions(String conditionLogic) {
        String simplified = replace(conditionLogic, "true", "1");
        String ready = replace(simplified, "false", "0");

        return evalNumbers(ready);
    }
}
