/*
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.mysqlbinlog.client.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.github.mysqlbinlogreader.common.exception.RuntimeMysqlBinlogClientException;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ConnectionBasedMysqlStreamProviderImpl.class)
public class ConnectionBasedMysqlStreamProviderImplTest {
    
    private java.sql.Connection connection;
    private MysqlStreamProvider mysqlStreamProvider;
    
    @Before
    public void init() throws SQLException {
        PowerMockito.mockStatic(DriverManager.class);

        this.connection = DriverManager.getConnection("jdbc:mysql://mysql-hostmame", "username", "password");
        this.mysqlStreamProvider = new ConnectionBasedMysqlStreamProviderImpl();
    }
    
    @Test(expected = RuntimeMysqlBinlogClientException.class)
    public void retrieveStreamsTest() {
        mysqlStreamProvider.retrieveStreams(this.connection);
    }
}
