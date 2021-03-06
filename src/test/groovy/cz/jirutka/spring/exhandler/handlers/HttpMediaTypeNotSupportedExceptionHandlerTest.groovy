/*
 * Copyright 2014 Jakub Jirutka <jakub@jirutka.cz>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.jirutka.spring.exhandler.handlers

import org.springframework.web.HttpMediaTypeNotSupportedException
import spock.lang.Specification

import static org.springframework.http.MediaType.*

class HttpMediaTypeNotSupportedExceptionHandlerTest extends Specification {

    def handler = new HttpMediaTypeNotSupportedExceptionHandler()


    def 'create headers with "Accept" when supported media types are specified'() {
        given:
            def exception = new HttpMediaTypeNotSupportedException(IMAGE_GIF, [IMAGE_PNG, IMAGE_JPEG])
        when:
            def headers = handler.createHeaders(exception, null)
        then:
           headers.getAccept() == [IMAGE_PNG, IMAGE_JPEG]
    }

    def 'create headers without "Accept" when supported media types are not specified'() {
        given:
            def exception = new HttpMediaTypeNotSupportedException('foo')
        when:
            def result = handler.createHeaders(exception, null)
        then:
            ! result.get('Accept')
    }
}
