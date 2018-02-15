/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.iosched.ui.schedule

import com.google.samples.apps.iosched.shared.data.tag.TagRepository
import com.google.samples.apps.iosched.shared.model.Tag
import com.google.samples.apps.iosched.shared.usecases.repository.LoadTagsUseCase
import javax.inject.Inject

open class LoadTagsByCategoryUseCase @Inject constructor(repository: TagRepository)
    : LoadTagsUseCase(repository) {

    override fun execute(parameters: Unit): List<Tag> {
        return super.execute(parameters)
                .sortedWith(compareBy<Tag> { it.category }.thenBy { it.orderInCategory })
    }
}
