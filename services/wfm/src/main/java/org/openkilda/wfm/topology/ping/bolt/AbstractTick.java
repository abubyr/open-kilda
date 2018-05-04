/*
 * Copyright 2017 Telstra Open Source
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

package org.openkilda.wfm.topology.ping.bolt;

import org.openkilda.wfm.AbstractBolt;

import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.TupleUtils;

import java.util.Map;

public abstract class AbstractTick extends AbstractBolt {
    public static final String FIELD_ID_TIME_MILLIS = "time";
    public static final Fields STREAM_FIELDS = new Fields(FIELD_ID_TIME_MILLIS);

    private final Integer interval;

    public AbstractTick(Integer interval) {
        this.interval = interval;
    }

    @Override
    protected void handleInput(Tuple input) {
        if (!TupleUtils.isTick(input)) {
            return;
        }

        produceTick(input);
    }

    protected void produceTick(Tuple input) {
        getOutput().emit(input, new Values(System.currentTimeMillis()));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputManager) {
        outputManager.declare(STREAM_FIELDS);
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return TupleUtils.putTickFrequencyIntoComponentConfig(null, interval);
    }
}
