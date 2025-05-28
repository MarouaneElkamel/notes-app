import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Col, Row } from 'reactstrap';
import { TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './note.reducer';

export const NoteDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const noteEntity = useAppSelector(state => state.note.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="noteDetailsHeading">Note</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{noteEntity.id}</dd>
          <dt>
            <span id="title">Title</span>
          </dt>
          <dd>{noteEntity.title}</dd>
          <dt>
            <span id="content">Content</span>
          </dt>
          <dd>{noteEntity.content}</dd>
          <dt>
            <span id="createdAt">Created At</span>
          </dt>
          <dd>{noteEntity.createdAt ? <TextFormat value={noteEntity.createdAt} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="lastModifiedAt">Last Modified At</span>
          </dt>
          <dd>
            {noteEntity.lastModifiedAt ? <TextFormat value={noteEntity.lastModifiedAt} type="date" format={APP_DATE_FORMAT} /> : null}
          </dd>
          <dt>Tag</dt>
          <dd>
            {noteEntity.tags
              ? noteEntity.tags.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {noteEntity.tags && i === noteEntity.tags.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button tag={Link} to="/note" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/note/${noteEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default NoteDetail;
