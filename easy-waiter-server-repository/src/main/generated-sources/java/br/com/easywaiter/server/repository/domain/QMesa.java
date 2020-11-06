package br.com.easywaiter.server.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMesa is a Querydsl query type for Mesa
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMesa extends EntityPathBase<Mesa> {

    private static final long serialVersionUID = -1450139400L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMesa mesa = new QMesa("mesa");

    public final NumberPath<Long> codigoEstabelecimento = createNumber("codigoEstabelecimento", Long.class);

    public final QEstabelecimento estabelecimento;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> numero = createNumber("numero", Long.class);

    public final BooleanPath ocupado = createBoolean("ocupado");

    public QMesa(String variable) {
        this(Mesa.class, forVariable(variable), INITS);
    }

    public QMesa(Path<? extends Mesa> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMesa(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMesa(PathMetadata metadata, PathInits inits) {
        this(Mesa.class, metadata, inits);
    }

    public QMesa(Class<? extends Mesa> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.estabelecimento = inits.isInitialized("estabelecimento") ? new QEstabelecimento(forProperty("estabelecimento"), inits.get("estabelecimento")) : null;
    }

}

