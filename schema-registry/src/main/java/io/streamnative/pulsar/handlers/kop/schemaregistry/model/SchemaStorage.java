/**
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
package io.streamnative.pulsar.handlers.kop.schemaregistry.model;

import io.streamnative.pulsar.handlers.kop.schemaregistry.model.impl.SchemaStorageException;
import java.util.List;

public interface SchemaStorage {

    /**
     * Get current tenant.
     * @return
     */
    String getTenant();

    /**
     * Find a schema by unique id.
     * @param id the id
     * @return the Schema or null
     */
    Schema findSchemaById(int id) throws SchemaStorageException;

    /**
     * Find Schemas that have the same definition.
     * @param schemaDefinition the expected schema
     * @return the list of schemas
     */
    List<Schema> findSchemaByDefinition(String schemaDefinition) throws SchemaStorageException;

    /**
     * Get all existing subjects.
     * @return
     */
    List<String> getAllSubjects() throws SchemaStorageException;

    /**
     * Get all versions for a given subject.
     * @param subject the Subject
     * @return the list of versions
     */
    List<Integer> getAllVersionsForSubject(String subject) throws SchemaStorageException;

    /**
     * Delete all the versions of a subject.
     * @param subject the Subject
     * @return the versions
     */
    List<Integer> deleteSubject(String subject) throws SchemaStorageException;

    /**
     * Lookup a schema by subject and version.
     * @param subject the Subject
     * @param version the Version
     * @return the Schema
     */
    Schema findSchemaBySubjectAndVersion(String subject, int version) throws SchemaStorageException;

    /**
     * Create a new schema.
     * @param subject the Subject
     * @param schemaType the type
     * @param schemaDefinition the schema
     * @param forceCreate require to create a new version, without looking for an existing schema
     * @return the new Schema
     */
    Schema createSchemaVersion(String subject, String schemaType, String schemaDefinition,
                               boolean forceCreate) throws SchemaStorageException;
}
