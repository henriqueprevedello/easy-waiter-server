package br.com.easywaiter.server.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QComanda is a Querydsl query type for Comanda
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComanda extends EntityPathBase<Comanda> {

    private static final long serialVersionUID = 1968922137L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QComanda comanda = new QComanda("comanda");

    public final QCliente cliente;

    public final NumberPath<Long> codigoCliente = createNumber("codigoCliente", Long.class);

    public final NumberPath<Long> codigoEstabelecimento = createNumber("codigoEstabelecimento", Long.class);

    public final DateTimePath<java.util.Date> dataAbertura = createDateTime("dataAbertura", java.util.Date.class);

    public final DateTimePath<java.util.Date> dataFechamento = createDateTime("dataFechamento", java.util.Date.class);

    public final QEstabelecimento estabelecimento;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mesa = createString("mesa");

    public final ListPath<Pedido, QPedido> pedidos = this.<Pedido, QPedido>createList("pedidos", Pedido.class, QPedido.class, PathInits.DIRECT2);

    public QComanda(String variable) {
        this(Comanda.class, forVariable(variable), INITS);
    }

    public QComanda(Path<? extends Comanda> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QComanda(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QComanda(PathMetadata metadata, PathInits inits) {
        this(Comanda.class, metadata, inits);
    }

    public QComanda(Class<? extends Comanda> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cliente = inits.isInitialized("cliente") ? new QCliente(forProperty("cliente"), inits.get("cliente")) : null;
        this.estabelecimento = inits.isInitialized("estabelecimento") ? new QEstabelecimento(forProperty("estabelecimento"), inits.get("estabelecimento")) : null;
    }

}

