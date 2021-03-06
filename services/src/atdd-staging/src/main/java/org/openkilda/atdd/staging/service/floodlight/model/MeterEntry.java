/* Copyright 2018 Telstra Open Source
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.openkilda.atdd.staging.service.floodlight.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Value
public class MeterEntry {

    private List<String> flags;
    private int meterId;
    private List<MeterBand> entries;
    private String version;

    public MeterEntry(
            @JsonProperty("flags") List<String> flags, @JsonProperty("meterId") int meterId,
            @JsonProperty("entries") List<MeterBand> entries, @JsonProperty("version") String version) {
        this.flags = flags;
        this.meterId = meterId;
        this.entries = entries;
        this.version = version;
    }
}
