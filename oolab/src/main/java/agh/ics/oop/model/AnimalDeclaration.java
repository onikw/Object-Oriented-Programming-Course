package agh.ics.oop.model;

public interface AnimalDeclaration<T, P> {
    T create(P position);
}

