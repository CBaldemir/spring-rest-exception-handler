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
package cz.jirutka.spring.exhandler.fixtures

import cz.jirutka.spring.exhandler.handlers.RestExceptionHandler
import cz.jirutka.spring.exhandler.messages.ErrorMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import javax.servlet.http.HttpServletRequest

class ZuulExceptionHandler implements RestExceptionHandler<ZuulException, ErrorMessage> {

    ResponseEntity<ErrorMessage> handleException(ZuulException exception, HttpServletRequest request) {
        def body = new ErrorMessage(title: "There's no Dana, only Zuul!")
        new ResponseEntity<>(body, HttpStatus.NOT_FOUND)
    }
}
