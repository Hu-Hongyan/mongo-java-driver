/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mongodb;

import java.io.Serializable;

// TODO: change name to DocumentReference
// TODO: support database as well as collection

/**
 * A reference by _id to a document in a particular collection.
 *
 * @since 3.0
 * @mongodb.driver.manual applications/database-references Database References
 */
public class DBRef implements Serializable {

    private static final long serialVersionUID = 3437976873151865299L;

    private final Object id;
    private final String ref;

    public DBRef(final Object id, final String namespace) {
        this.id = id;
        ref = namespace;
    }

    /**
     * Gets the object's id
     *
     * @return the ID
     */
    public Object getId() {
        return id;
    }

    /**
     * Gets the object's namespace (collection name)
     *
     * @return the namespace
     */
    public String getRef() {
        return ref;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DBRef dbRef = (DBRef) o;

        if (!id.equals(dbRef.id)) {
            return false;
        }
        return ref.equals(dbRef.ref);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + ref.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DBRef{id=" + id + ", ref='" + ref + '\'' + '}';
    }
}
