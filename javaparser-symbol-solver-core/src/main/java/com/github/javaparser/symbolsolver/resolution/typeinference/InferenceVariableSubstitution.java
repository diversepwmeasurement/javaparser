/*
 * Copyright (C) 2015-2016 Federico Tomassetti
 * Copyright (C) 2017-2024 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */

package com.github.javaparser.symbolsolver.resolution.typeinference;

import com.github.javaparser.resolution.types.ResolvedType;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Federico Tomassetti
 */
public class InferenceVariableSubstitution {

    private static final InferenceVariableSubstitution EMPTY = new InferenceVariableSubstitution();

    private List<InferenceVariable> inferenceVariables;
    private List<ResolvedType> types;

    public static InferenceVariableSubstitution empty() {
        return EMPTY;
    }

    private InferenceVariableSubstitution() {
        this.inferenceVariables = new LinkedList<>();
        this.types = new LinkedList<>();
    }

    public InferenceVariableSubstitution withPair(InferenceVariable inferenceVariable, ResolvedType type) {
        InferenceVariableSubstitution newInstance = new InferenceVariableSubstitution();
        newInstance.inferenceVariables.addAll(this.inferenceVariables);
        newInstance.types.addAll(this.types);
        newInstance.inferenceVariables.add(inferenceVariable);
        newInstance.types.add(type);
        return newInstance;
    }
}
