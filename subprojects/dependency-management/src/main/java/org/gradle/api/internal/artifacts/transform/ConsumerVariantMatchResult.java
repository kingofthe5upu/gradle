/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.internal.artifacts.transform;

import org.gradle.api.internal.attributes.ImmutableAttributes;

import java.util.Collection;

public interface ConsumerVariantMatchResult {

    boolean hasMatches();

    Collection<ConsumerVariant> getMatches();

    class ConsumerVariant implements VariantDefinition {
        final ImmutableAttributes attributes;
        final Transformation transformation;
        final int depth;

        public ConsumerVariant(ImmutableAttributes attributes, Transformation transformation, int depth) {
            this.attributes = attributes;
            this.transformation = transformation;
            this.depth = depth;
        }

        @Override
        public ImmutableAttributes getTargetAttributes() {
            return attributes;
        }

        @Override
        public Transformation getTransformation() {
            return transformation;
        }
    }
}
