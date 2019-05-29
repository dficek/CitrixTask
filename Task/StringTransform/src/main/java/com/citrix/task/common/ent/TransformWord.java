package com.citrix.task.common.ent;

import java.io.Serializable;
import java.util.Objects;

/**
 * Main entity with origin and transform word
 *
 * @author Ficek Daniel
 */
public class TransformWord implements Serializable {

    private static final long serialVersionUID = -4763119013595232739L;

    // Origin word
    private String origin;
    // Transformed word
    private String transformed;

    public TransformWord(String word) {
        origin = word;
        transformed = word;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTransformed() {
        return transformed;
    }

    public void setTransformed(String transformed) {
        this.transformed = transformed;
    }

    public String toResultText() {
        return "origin='" + origin + '\'' +
                ", transformed='" + transformed + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransformWord that = (TransformWord) o;
        return Objects.equals(getOrigin(), that.getOrigin()) &&
                Objects.equals(getTransformed(), that.getTransformed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigin(), getTransformed());
    }

    @Override
    public String toString() {
        return "TransformWord{" +
                "origin='" + origin + '\'' +
                ", transformed='" + transformed + '\'' +
                '}';
    }

}
