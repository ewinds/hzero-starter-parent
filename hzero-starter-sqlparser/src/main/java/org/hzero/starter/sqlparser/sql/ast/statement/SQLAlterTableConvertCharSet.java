/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hzero.starter.sqlparser.sql.ast.statement;

import org.hzero.starter.sqlparser.sql.ast.SQLExpr;
import org.hzero.starter.sqlparser.sql.ast.SQLObjectImpl;
import org.hzero.starter.sqlparser.sql.visitor.SQLASTVisitor;

public class SQLAlterTableConvertCharSet extends SQLObjectImpl implements SQLAlterTableItem {

    private SQLExpr charset;
    private SQLExpr collate;
    
    public SQLAlterTableConvertCharSet() {
        
    }

    public SQLExpr getCharset() {
        return charset;
    }

    public void setCharset(SQLExpr charset) {
        if (charset != null) {
            charset.setParent(this);
        }
        this.charset = charset;
    }

    public SQLExpr getCollate() {
        return collate;
    }

    public void setCollate(SQLExpr collate) {
        if (collate != null) {
            collate.setParent(this);
        }
        this.collate = collate;
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, charset);
            acceptChild(visitor, collate);
        }
        visitor.endVisit(this);
    }

}