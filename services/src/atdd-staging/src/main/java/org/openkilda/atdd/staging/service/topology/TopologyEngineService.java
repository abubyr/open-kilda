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

package org.openkilda.atdd.staging.service.topology;

import org.openkilda.messaging.info.event.IslChangeType;
import org.openkilda.messaging.info.event.IslInfoData;
import org.openkilda.messaging.info.event.PathInfoData;
import org.openkilda.messaging.info.event.SwitchInfoData;
import org.openkilda.messaging.model.Flow;
import org.openkilda.messaging.model.ImmutablePair;
import org.openkilda.topo.ITopology;

import java.util.List;
import java.util.stream.Collectors;

public interface TopologyEngineService {

    List<IslInfoData> getAllLinks();

    default List<IslInfoData> getActiveLinks() {
        return getAllLinks().stream()
                .filter(sw -> sw.getState() == IslChangeType.DISCOVERED)
                .collect(Collectors.toList());
    }

    Integer getLinkBandwidth(String srcSwitch, String srcPort);

    List<SwitchInfoData> getAllSwitches();

    default List<SwitchInfoData> getActiveSwitches() {
        return getAllSwitches().stream()
                .filter(sw -> sw.getState().isActive())
                .collect(Collectors.toList());
    }

    List<Flow> getAllFlows();

    ImmutablePair<Flow, Flow> getFlow(String flowId);

    void restoreFlows();

    ITopology getTopology();

    String clearTopology();

    List<PathInfoData> getPaths(String srcSwitch, String dstSwitch);

}
