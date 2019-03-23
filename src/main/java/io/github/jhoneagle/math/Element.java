package io.github.jhoneagle.math;

public class Element {
    private int elementId;

    public Element(int elementId) {
        this.elementId = elementId;
    }

    /**
     * Id of the class that inspecting.
     *
     * @return unique number of the class that extends this class.
     */
    public int getElementId() {
        return elementId;
    }
}
