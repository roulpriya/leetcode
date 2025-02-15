package com.app;

import java.util.Optional;

public interface List<T> {

    Optional<T> get(int index);

    int size();
}
