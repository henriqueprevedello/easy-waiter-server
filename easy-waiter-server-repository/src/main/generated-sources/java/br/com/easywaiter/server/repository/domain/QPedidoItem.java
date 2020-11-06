package br.com.easywaiter.server.repository.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPedidoItem is a Querydsl query type for PedidoItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPedidoItem extends EntityPathBase<PedidoItem> {

    private static final long serialVersionUID = -2141040246L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPedidoItem pedidoItem = new QPedidoItem("pedidoItem");

    public final NumberPath<Long> codigoPedido = createNumber("codigoPedido", Long.class);

    public final NumberPath<Long> codigoProduto = createNumber("codigoProduto", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPedido pedido;

    public final QProduto produto;

    public final NumberPath<Long> quantidade = createNumber("quantidade", Long.class);

    public QPedidoItem(String variable) {
        this(PedidoItem.class, forVariable(variable), INITS);
    }

    public QPedidoItem(Path<? extends PedidoItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPedidoItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPedidoItem(PathMetadata metadata, PathInits inits) {
        this(PedidoItem.class, metadata, inits);
    }

    public QPedidoItem(Class<? extends PedidoItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pedido = inits.isInitialized("pedido") ? new QPedido(forProperty("pedido"), inits.get("pedido")) : null;
        this.produto = inits.isInitialized("produto") ? new QProduto(forProperty("produto"), inits.get("produto")) : null;
    }

}

