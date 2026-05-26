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

import de.odrotbohm.spring.hotwire.webmvc.TurboStreams.TurboStream;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.springframework.util.Assert;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafView;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * API to conveniently build Hotwire streams.
 *
 * @author Oliver Drotbohm
 */
@RequiredArgsConstructor
public class WebMvcHotwire implements Hotwire {

    @NonNull
    private final ThymeleafViewResolver views;

    @NonNull
    private final SpringTemplateEngine engine;

    @NonNull
    private final LocaleResolver locales;

    /*
	 * (non-Javadoc)
	 * @see org.springframework.boot.hotwire.webmvc.WebMvcHotwire#stream()
	 */
    public TurboStreams stream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.boot.hotwire.webmvc.WebMvcHotwire#toView(org.springframework.boot.hotwire.webmvc.TurboStreams)
	 */
    public View toView(TurboStreams streams) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /*
	 * (non-Javadoc)
	 * @see org.springframework.boot.hotwire.webmvc.WebMvcHotwire#toSsePayload(org.springframework.boot.hotwire.webmvc.TurboStreams, java.util.Map)
	 */
    public String toSsePayload(TurboStreams streams, Map<String, Object> model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
