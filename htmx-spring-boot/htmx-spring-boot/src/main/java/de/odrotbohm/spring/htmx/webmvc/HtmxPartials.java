/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.odrotbohm.spring.htmx.webmvc;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.util.Assert;

/**
 * Representation of HTMX partials.
 *
 * @author Oliver Drotbohm
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class HtmxPartials {

    private final Collection<Partial> streams;

    public HtmxPartials() {
        this.streams = new ArrayList<>();
    }

    /**
     * Append the rendered fragment.
     *
     * @param target must not be {@literal null} or empty.
     * @return
     */
    public HtmxPartialsBuilder append(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Prepend the rendered fragment.
     *
     * @param target must not be {@literal null} or empty.
     * @return
     */
    public HtmxPartialsBuilder prepend(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Remove the rendered fragment.
     *
     * @param template must not be {@literal null} or empty.
     * @return
     */
    public HtmxPartials remove(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Replace the rendered fragment.
     *
     * @param target must not be {@literal null} or empty.
     * @return
     */
    public HtmxPartialsBuilder replace(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Update the rendered fragment.
     *
     * @param target must not be {@literal null} or empty.
     * @return
     */
    public HtmxPartialsBuilder update(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Iterable<Partial> toIterable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public enum Action {

        APPEND, PREPEND, REPLACE, UPDATE, REMOVE;

        String toAttribute() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Value
    @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
    public static class HtmxPartialsBuilder {

        private Collection<Partial> streams;

        private String target;

        private Action action;

        /**
         * @param templateOrFragment the identifier of a template or fragment.
         * @return will never be {@literal null}.
         */
        public HtmxPartials with(String templateOrFragment) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Renders the fragment with the current target name within the given template.
         *
         * @param template must not be {@literal null} or empty.
         * @return will never be {@literal null}.
         */
        public HtmxPartials withinTemplate(String template) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Renders the given fragment as Turbo Stream.
         *
         * @param fragment must not be {@literal null} or empty and a valid fragment identifier.
         * @return will never be {@literal null}.
         */
        public HtmxPartials withFragment(String fragment) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private HtmxPartials and(Partial stream) {
            List<Partial> list = new ArrayList<>(streams);
            list.add(stream);
            return new HtmxPartials(list);
        }
    }

    @Value
    static class Partial {

        Action action;

        String target, template;

        String openWrapper() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        String closeWrapper() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean isRemove() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean isReplace() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
