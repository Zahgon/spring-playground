/*
 * Copyright 2020-2022 the original author or authors.
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
package de.odrotbohm.spring.web.model;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.CheckReturnValue;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * A monadic type to implement Spring MVC handler methods in a functional way.
 *
 * @author Oliver Drotbohm
 */
@CheckReturnValue
public interface MappedPayloads {

    /**
     * Creates a new {@link MappedErrors} from the given {@link Errors} instance.
     *
     * @param errors must not be {@literal null}.
     * @return will never be {@literal null}.
     */
    public static MappedErrors of(Errors errors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new {@link MappedPayload} for the given source instance
     *
     * @param <T>
     * @param payload can be {@literal null}.
     * @param errors
     * @return
     */
    public static <T> MappedPayload<T> of(@Nullable T payload, Errors errors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a new {@link MappedPayload} of the given source and {@link Errors}. Of the source is empty, a
     * {@link HttpStatus#NOT_FOUND} will be produced independent of the built up pipeline.
     *
     * @param <T>
     * @param source must not be {@literal null}.
     * @param errors must not be {@literal null}.
     * @return
     */
    public static <T> MappedPayload<T> of(Optional<T> source, Errors errors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Syntactic sugar to easily create a {@link HttpStatus#BAD_REQUEST} response from an {@link Errors} instance in a
     * {@link Stream} mapping step or the like.
     *
     * @param errors must not be {@literal null}.
     * @return will never be {@literal null}.
     */
    public static ResponseEntity<?> toBadRequest(Errors errors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    @RequiredArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MappedErrors {

        @NonNull
        private final Errors errors;

        private final Map<String, Object> details;

        protected final Function<Errors, ResponseEntity<?>> onErrors;

        private final BiConsumer<Errors, ProblemDetail> customizer;

        private MappedErrors(Errors errors) {
            this.errors = errors;
            this.details = new LinkedHashMap<>();
            this.onErrors = MappedPayloads::toBadRequest;
            this.customizer = (err, details) -> {
            };
        }

        /**
         * Creates a new {@link MappedPayload} with the given payload and the current {@link Errors} instance.
         *
         * @param <T>
         * @param payload must not be {@literal null}.
         * @return will never be {@literal null}.
         */
        public <T> MappedPayload<T> with(T payload) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Allows to peek at the current {@link Errors} instance.
         *
         * @param errors must not be {@literal null}.
         * @return the current instance, never {@literal null}.
         */
        public MappedErrors peekErrors(Consumer<Errors> errors) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public MappedErrors reject(Consumer<Map<String, Object>> details) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public MappedErrors reject(String errorCode, Consumer<Map<String, Object>> details) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Rejects the field of the given name with the given error code.
         *
         * @param field must not be {@literal null} or empty.
         * @param errorCode must not be {@literal null} or empty.
         * @return the current instance, never {@literal null}.
         */
        public MappedErrors rejectField(String field, String errorCode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Rejects the field with the given name with the given error code if the given condition is true.
         *
         * @param condition the condition under which to reject the given field.
         * @param field must not be {@literal null} or empty.
         * @param errorCode must not be {@literal null} or empty.
         * @return the current instance, never {@literal null}.
         */
        public MappedErrors rejectField(boolean condition, String field, String errorCode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Rejects the field with the given name with the given error code and default message.
         *
         * @param field must not be {@literal null} or empty.
         * @param errorCode must not be {@literal null} or empty.
         * @param defaultMessage must not be {@literal null} or empty.
         * @return the current instance, never {@literal null}.
         */
        public MappedErrors rejectField(String field, String errorCode, String defaultMessage) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Rejects the field with the given name with the given error code if the given condition is true.
         *
         * @param condition the condition under which to reject the given field.
         * @param field must not be {@literal null} or empty.
         * @param errorCode must not be {@literal null} or empty.
         * @param errorHandler and error handler to be registered in case the condition is {@literal true}.
         * @return the current instance, never {@literal null}.
         */
        public MappedErrors rejectField(boolean condition, String field, String errorCode, Function<Errors, ResponseEntity<?>> errorHandler) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Unconditionally creates a {@link HttpStatus#BAD_REQUEST} with the current {@link Errors} as payload.
         *
         * @return will never be {@literal null}.
         */
        public ResponseEntity<?> toBadRequest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates an {@link HttpEntity} if the {@link MappedPayload} is valid, i.e. the underlying {@link Errors} has not
         * accumulated any errors through previous validations.
         *
         * @param response must not be {@literal null}.
         * @return
         */
        public ResponseEntity<?> onValidGet(Supplier<ResponseEntity<?>> response) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Registers a {@link Function} to eventually turn an {@link Errors} instance into an {@link HttpEntity}. Will only
         * be used if the {@link Errors} have accumulated at least one error in the pipeline.
         *
         * @param callback must not be {@literal null}.
         * @return
         */
        @CheckReturnValue
        public MappedErrors onErrors(Function<Errors, ResponseEntity<?>> callback) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public MappedErrors onErrors(Supplier<ResponseEntity<?>> callback) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Customize the given {@link ProblemDetail} instance based on the ultimate {@link Errors} instance.
         *
         * @param customizer must not be {@literal null}.
         * @return will never be {@literal null}.
         */
        public MappedErrors onErrors(BiConsumer<Errors, ProblemDetail> customizer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected Optional<ResponseEntity<?>> errorsOrNone() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A monadic type to work with a mapped payload alongside {@link Errors} to build up pipelines to eventually result in
     * an {@link HttpEntity} based on the processing steps.
     *
     * @author Oliver Drotbohm
     */
    @CheckReturnValue
    public static class MappedPayload<T> extends MappedErrors {

        private final Errors errors;

        @Nullable
        private final T payload;

        private final Supplier<ResponseEntity<?>> onAbsence;

        /**
         * Creates a new {@link MappedPayload} with the given payload and {@link Errors}.
         *
         * @param <T>
         * @param payload can be {@literal null}.
         * @param errors must not be {@literal null}.
         * @return will never be {@literal null}.
         */
        private static <T> MappedPayload<T> of(@Nullable T payload, Errors errors) {
            Assert.notNull(errors, "Errors must not be null!");
            return of(payload, errors, it -> ResponseEntity.badRequest().body(it), () -> ResponseEntity.notFound().build());
        }

        private static <T> MappedPayload<T> of(@Nullable T payload, Errors errors, Function<Errors, ResponseEntity<?>> onErrors, Supplier<ResponseEntity<?>> onAbsence) {
            Assert.notNull(onAbsence, "Abscence callback must not be null!");
            Assert.notNull(onErrors, "Errors callback must not be null!");
            return new MappedPayload<>(payload, errors, onErrors, onAbsence);
        }

        private MappedPayload(@Nullable T payload, Errors errors, Function<Errors, ResponseEntity<?>> onErrors, Supplier<ResponseEntity<?>> onAbsence) {
            super(errors, new LinkedHashMap<>(), onErrors, (err, details) -> {
            });
            Assert.notNull(onAbsence, "Absence callback must not be null!");
            this.errors = errors;
            this.payload = payload;
            this.onAbsence = onAbsence;
        }

        /**
         * Switches the {@link MappedPayload} to unconditionally produce an {@link HttpEntity} with status code
         * {@link HttpStatus#NOT_FOUND}. Customize the eventual creation of that using {@link #onAbsence(Supplier)}.
         *
         * @param guard whether to end up with {@link HttpStatus#NOT_FOUND} or not.
         * @return will never be {@literal null}.
         * @see #onAbsence(Supplier)
         */
        public MappedPayload<T> notFoundIf(boolean guard) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Turns the {@link MappedPayload} to unconditionally produce an {@link HttpEntity} with status code
         * {@link HttpStatus#NOT_FOUND} if the given predicate on the payload matches. Customize the eventual creation of
         * that using {@link #onAbsence(Supplier)}.
         *
         * @param predicate must not be {@literal null}.
         * @return will never be {@literal null}.
         * @see #onAbsence(Supplier)
         */
        public MappedPayload<T> notFoundIf(Predicate<? super T> predicate) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Peeks at the payload if present and no errors have been accumulated or we're on a path to a
         * {@link HttpStatus#NOT_FOUND} yet.
         *
         * @param consumer must not be {@literal null}.
         * @return the current instance, never {@literal null}.
         */
        public MappedPayload<T> peekIfValid(Consumer<? super T> consumer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Peeks at the given payload and {@link Errors} if no errors have been accumulated or we're on a path to a
         * {@link HttpStatus#NOT_FOUND} yet.
         *
         * @param consumer
         * @return the current instance, never {@literal null}.
         */
        public MappedPayload<T> peekIfValid(BiConsumer<? super T, Errors> consumer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public MappedPayload<T> peek(Consumer<? super T> consumer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public MappedPayload<T> peek(BiConsumer<? super T, Errors> consumer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Syntactic sugar to invoke validations in a readable way. Essentially the same as {@link #peek(BiConsumer)}. Easy
         * to use with the YAVI {@link YaviValidator} adapter. For use with Spring's {@link Validator} interface, see
         * {@link #validate(Validator)}.
         *
         * @param validator must not be {@literal null}.
         * @return
         * @see #validate(Validator)
         */
        public MappedPayload<T> validate(BiConsumer<? super T, Errors> validator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Syntactic sugar to invoke validations in a readable way. Essentially the same as {@link #peek(BiConsumer)}. Easy
         * to use with Spring's own {@link Validator} interface.
         *
         * @param validator must not be {@literal null}.
         * @return
         * @see #validate(BiConsumer)
         */
        public MappedPayload<T> validate(Validator validator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Applies the given {@link Function}, even if errors have been accumulated.
         *
         * @param <S>
         * @param mapper must not be {@literal null}.
         * @return will never be {@literal null}.
         */
        @SuppressWarnings("unchecked")
        public <S> MappedPayload<S> map(Function<? super T, S> mapper) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        public <S> MappedPayload<S> flatMap(Function<? super T, Optional<S>> mapper) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Applies the given {@link Function} if no errors have been accumulated or we're on a path to a
         * {@link HttpStatus#NOT_FOUND} yet.
         *
         * @param <S>
         * @param mapper must not be {@literal null}.
         * @return
         */
        @SuppressWarnings("unchecked")
        public <S> MappedPayload<S> mapIfValid(Function<? super T, S> mapper) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        public <S> MappedPayload<S> flatMapIfValid(Function<? super T, Optional<S>> mapper) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public <S> MappedPayload<S> map(BiFunction<? super T, Errors, S> mapper) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        public <S> MappedPayload<S> mapIfValid(BiFunction<? super T, Errors, S> mapper) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /*
		 * (non-Javadoc)
		 * @see de.odrotbohm.spring.web.model.MappedPayloads.MappedErrors#onErrors(java.util.function.Function)
		 */
        @Override
        public MappedPayload<T> onErrors(Function<Errors, ResponseEntity<?>> callback) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /*
		 * (non-Javadoc)
		 * @see de.odrotbohm.spring.web.model.MappedPayloads.MappedErrors#onErrors(java.util.function.Supplier)
		 */
        @Override
        public MappedPayload<T> onErrors(Supplier<ResponseEntity<?>> callback) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Registers a {@link Function} to create an {@link ResponseEntity} in case the pipeline yields the absence of a
         * payload.
         *
         * @param callback must not be {@literal null}.
         * @return
         * @see #notFoundIf(boolean)
         * @see #notFoundIf(Predicate)
         */
        public MappedPayload<T> onAbsence(Supplier<ResponseEntity<?>> callback) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Registers the given field to be rejected on payload absence. Transparently registers the error handler as absence
         * handler.
         *
         * @param field must not be {@literal null} or empty.
         * @param errorCode must not be {@literal null} or empty.
         * @return will never be {@literal null}.
         */
        public MappedPayload<T> onAbsenceReject(String field, String errorCode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Concludes the processing of the current payload with the given finalizer, but automatically produces an error
         * response via the callbacks registered for {@link #onErrors} and {@link #onAbsence}.
         *
         * @param finalizer must not be {@literal null}.
         * @return
         */
        @SuppressWarnings("unchecked")
        public <S, R extends ResponseEntity<? extends S>> R concludeIfValid(Function<? super T, R> finalizer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Concludes the processing of the current payload with the given finalizer, but automatically produces an error
         * response via the callbacks registered for {@link #onErrors} and {@link #onAbsence}.
         *
         * @param finalizer must not be {@literal null}.
         * @return
         */
        public HttpEntity<?> concludeIfValid(BiFunction<? super T, Errors, ? extends ResponseEntity<?>> finalizer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Concludes the processing of the current payload with the given finalizer, but automatically produces an error
         * response via the callbacks registered for {@link #onErrors} and {@link #onAbsence}.
         *
         * @param finalizer must not be {@literal null}.
         * @return
         */
        public HttpEntity<?> concludeSelfIfValid(BiFunction<? super T, MappedErrors, ? extends ResponseEntity<?>> finalizer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Terminal operation that produces an empty response with {@link HttpStatus#NO_CONTENT}.
         *
         * @return
         */
        public HttpEntity<?> concludeWithoutContent() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /*
		 * (non-Javadoc)
		 * @see de.odrotbohm.spring.web.model.MappedPayloads.MappedErrors#rejectField(boolean, java.lang.String, java.lang.String)
		 */
        @Override
        public MappedPayload<T> rejectField(boolean condition, String field, String errorCode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Rejects the field with the given name with the given error code if the given condition predicate returns true.
         *
         * @param condition the condition predicate under which to reject the given field.
         * @param field must not be {@literal null} or empty.
         * @param errorCode must not be {@literal null} or empty.
         * @return the current instance, never {@literal null}.
         */
        public MappedPayload<T> rejectField(Predicate<T> condition, String field, String errorCode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /*
		 * (non-Javadoc)
		 * @see de.odrotbohm.spring.web.model.MappedPayloads.MappedErrors#rejectField(java.lang.String, java.lang.String)
		 */
        @Override
        public MappedPayload<T> rejectField(String field, String errorCode) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /*
		 * (non-Javadoc)
		 * @see de.odrotbohm.spring.web.model.MappedPayloads.MappedErrors#rejectField(java.lang.String, java.lang.String, java.lang.String)
		 */
        @Override
        public MappedPayload<T> rejectField(String field, String errorCode, String defaultMessage) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Rejects the field with the given name with the given error code if the given condition is true.
         *
         * @param condition the condition under which to reject the given field.
         * @param field must not be {@literal null} or empty.
         * @param errorCode must not be {@literal null} or empty.
         * @param errorHandler and error handler to be registered in case the condition is {@literal true}.
         * @return the current instance, never {@literal null}.
         */
        @Override
        public MappedPayload<T> rejectField(boolean condition, String field, String errorCode, Function<Errors, ResponseEntity<?>> errorHandler) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private <S> MappedPayload<S> withoutPayload() {
            return of(null, errors, onErrors, onAbsence);
        }

        private <S> MappedPayload<S> withPayload(S payload) {
            return of(payload, errors, onErrors, onAbsence);
        }

        /*
		 * (non-Javadoc)
		 * @see de.odrotbohm.spring.web.model.MappedPayloads.MappedErrors#errorsOrNone()
		 */
        @Override
        protected Optional<ResponseEntity<?>> errorsOrNone() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
