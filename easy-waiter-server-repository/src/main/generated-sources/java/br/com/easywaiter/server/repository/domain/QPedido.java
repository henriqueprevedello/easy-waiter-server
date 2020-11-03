package br.com.easywaiter.server.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPedido is a Querydsl query type for Pedido
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPedido extends EntityPathBase<Pedido> {

    private static final long serialVersionUID = -1929108009L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPedido pedido = new QPedido("pedido");

    public final NumberPath<Long> codigoComanda = createNumber("codigoComanda", Long.class);

    public final QComanda comanda;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<PedidoItem, QPedidoItem> pedidosItem = this.<PedidoItem, QPedidoItem>createList("pedidosItem", PedidoItem.class, QPedidoItem.class, PathInits.DIRECT2);

    public QPedido(String variable) {
        this(Pedido.class, forVariable(variable), INITS);
    }

    public QPedido(Path<? extends Pedido> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPedido(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPedido(PathMetadata metadata, PathInits inits) {
        this(Pedido.class, metadata, inits);
    }

    public QPedido(Class<? extends Pedido> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.comanda = inits.isInitialized("comanda") ? new QComanda(forProperty("comanda"), inits.get("comanda")) : null;
    }

}

