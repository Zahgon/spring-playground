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
package de.odrotbohm.spring.hotwire.webmvc;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.springframework.util.Assert;

/**
 * Representation of Turbo Streams.
 *
 * @author Oliver Drotbohm
 */
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TurboStreams {

    private final Collection<TurboStream> streams;

    public TurboStreams() {
        this.streams = new ArrayList<>();
    }

    /**
     * Append the rendered turbo stream template or fragment.
     *
     * @param target must not be {@literal null} or empty.
     * @return
     */
    public TurboStreamBuilder append(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Append the rendered turbo stream template or fragment.
     *
     * @param target must not be {@literal null} or empty.
     * @return
     */
    public TurboStreamBuilder prepend(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Remove the rendered turbo stream template or fragment.
     *
     * @param template must not be {@literal null} or empty.
     * @return
     */
    public TurboStreams remove(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Replace the rendered turbo stream template or fragment.
     *
     * @param target must not be {@literal null} or empty.
     * @return
     */
    public TurboStreamBuilder replace(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Update the rendered turbo stream template or fragment.
     *
     * @param target must not be {@literal null} or empty.
     * @return
     */
    public TurboStreamBuilder update(String target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    Iterable<TurboStream> toIterable() {
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
    public static class TurboStreamBuilder {

        private Collection<TurboStream> streams;

        private String target;

        private Action action;

        /**
         * @param templateOrFragment the identifier of a template or fragment.
         * @return will never be {@literal null}.
         */
        public TurboStreams with(String templateOrFragment) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Renders the fragment with the current target name within the given template.
         *
         * @param template must not be {@literal null} or empty.
         * @return will never be {@literal null}.
         */
        public TurboStreams withinTemplate(String template) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Renders the given fragment as Turbo Stream.
         *
         * @param fragment must not be {@literal null} or empty and a valid fragment identifier.
         * @return will never be {@literal null}.
         */
        public TurboStreams withFragment(String fragment) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private TurboStreams and(TurboStream stream) {
            List<TurboStream> list = new ArrayList<>(streams);
            list.add(stream);
            return new TurboStreams(list);
        }
    }

    @Value
    static class TurboStream {

        Action action;

        String target, template;

        String openStream() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        String closeStream() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        String openTemplate() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        String openTemplateFormatted() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        String closeTemplate() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        String closeTemplateFormatted() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean isRemove() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
